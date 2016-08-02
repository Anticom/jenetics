/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetix;

import java.util.Optional;
import java.util.stream.Stream;

import org.jenetics.Chromosome;

import org.jenetix.util.TreeNode;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public interface TreeChromosome<A, G extends TreeGene<A, G>>
	extends Chromosome<G>
{

	/**
	 * Return the root gene of the {@code TreeChromosome}.
	 *
	 * @return the root gene of the {@code TreeChromosome}
	 */
	public default G getRoot() {
		return getGene();
	}

	public default Optional<G> getParent(final G child) {
		return child.getParent(toSeq());
	}

	public default G getChild(final G parent, final int index) {
		return parent.getChild(index, toSeq());
	}

	public default int childCount(final G parent) {
		return parent.childCount();
	}

	public default Stream<G> children(final G parent) {
		return parent.children(toSeq());
	}

	public default boolean isLeaf(final G gene) {
		return gene.isLeaf();
	}

	public default TreeNode<A> toTree() {
		return getRoot().toTreeNode(toSeq());
	}

}